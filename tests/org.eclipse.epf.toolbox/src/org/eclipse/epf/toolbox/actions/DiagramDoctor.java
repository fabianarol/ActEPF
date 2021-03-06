package org.eclipse.epf.toolbox.actions;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epf.authoring.ui.editors.EditorChooser;
import org.eclipse.epf.common.CommonPlugin;
import org.eclipse.epf.diagram.core.DiagramCorePlugin;
import org.eclipse.epf.diagram.core.services.DiagramHelper;
import org.eclipse.epf.diagram.core.services.DiagramManager;
import org.eclipse.epf.library.LibraryService;
import org.eclipse.epf.library.edit.util.IDiagramManager;
import org.eclipse.epf.services.Services;
import org.eclipse.epf.services.ILibraryPersister.FailSafeMethodLibraryPersister;
import org.eclipse.epf.toolbox.ToolboxPlugin;
import org.eclipse.epf.toolbox.libutil.LibUtil;
import org.eclipse.epf.uma.Activity;
import org.eclipse.epf.uma.MethodLibrary;
import org.eclipse.epf.uma.Process;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class DiagramDoctor implements IWorkbenchWindowActionDelegate {

	private static boolean debug = true;//ToolboxPlugin.getDefault().isDebugging();

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

	private void log(String line) {
		ToolboxPlugin.getDefault().getLogger().logInfo(line);
	}

	public void run(IAction action) {
		final IAction a = action;
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			public void execute(IProgressMonitor monitor) {
				monitor.beginTask("Clean up process diagram duplicate data ... ",
						10);
				monitor.worked(3);
				monitor.setTaskName("Clean up process diagram duplicate data ...");
				try {
					run_(a);
				} finally {
					monitor.done();
				}
			}
		};

		try {
			// Run the operation and display the progress.
			ProgressMonitorDialog pmDialog = new ProgressMonitorDialog(Display
					.getCurrent().getActiveShell());
			pmDialog.run(true, false, operation);
		} catch (Exception e) {
			ToolboxPlugin.getDefault().getLogger().logError(e);
		}
		
	}

	private void run_(IAction action) {
		long t0 = System.currentTimeMillis();
		if (debug) {
			System.out.println("");
			System.out.println("LD> Begin: DiagramDoctor.run()");
		}
		log("LD> Begin: DiagramDoctor.run()");
		MethodLibrary lib = LibraryService.getInstance()
				.getCurrentMethodLibrary();
		if (lib == null) {
			return;
		}

		EditorChooser.getInstance().closeAllMethodEditorsWithSaving();
		Set<Process> processes = LibUtil.collectProcesses(lib);
		for (Process proc : processes) {
			DiagramManager mgr = null;
			try {
				System.out.println("LD> proc: " + proc);
				mgr = DiagramManager.getInstance(proc, this);

				for (Activity act : LibUtil.collectActivities(proc)) {
					cleanupDiagrams(mgr, act);
				}

				System.out.println("");
			} finally {
				if (mgr != null) {
					mgr.removeConsumer(this);
				}
			}
		}

		if (debug) {
			long t1 = System.currentTimeMillis();
			double d = (t1 - t0) / 1000.0;
			int t = (int) d;

			System.out
					.println("LD> End: DiagramDoctor.run(), time (sec): " + t);
		}
		log("LD> End: DiagramDoctor.run()");
	}

	private void cleanupDiagrams(DiagramManager mgr, Activity act) {
		try {
			List<Diagram> diagrams = mgr.getDiagrams(act,
					IDiagramManager.ACTIVITY_DIAGRAM);
			Resource resource = null;
			Diagram diagram0 = null;
			boolean toDelete = false;
			int count = 0;
			for (Diagram diagram : diagrams) {
				if (toDelete) {
					if (diagram != diagram0) {
						DiagramHelper.deleteDiagram(diagram, false);
						count++;
					}
				} else {
					diagram0 = diagram;
					resource = diagram.eResource();
					toDelete = true;
				}
			}

			FailSafeMethodLibraryPersister persister = Services
					.getLibraryPersister(Services.XMI_PERSISTENCE_TYPE)
					.getFailSafePersister();
			try {
				persister.save(resource);
				persister.commit();
			} catch (Exception e) {
				CommonPlugin.getDefault().getLogger().logError(e);
				persister.rollback();
				throw new CoreException(new Status(IStatus.ERROR,
						DiagramCorePlugin.PLUGIN_ID, 1, e
								.getLocalizedMessage(), null));
			}
			if (count > 0) {
				if (debug) {
					System.out.println("LD> activity: " + act);
					System.out.println("LD> Removed data count: " + count);
				}
				log("LD> activity: " + act);
				log("LD> Removed data count: " + count);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log(e.getMessage());
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
