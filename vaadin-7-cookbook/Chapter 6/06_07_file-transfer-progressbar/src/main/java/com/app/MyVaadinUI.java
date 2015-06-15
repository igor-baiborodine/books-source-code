package com.app;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    private VerticalLayout layout = new VerticalLayout();

    @Override
    protected void init(VaadinRequest request) {
        layout.setMargin(true);
        setContent(layout);

        ProgressIndicator indicator = new ProgressIndicator(0.0f);
        UploadReceiver uploadReceiver = new UploadReceiver(indicator);
        Upload upload = new Upload("Upload", uploadReceiver);
        upload.addProgressListener(uploadReceiver);
        upload.addFinishedListener(uploadReceiver);
        upload.addStartedListener(uploadReceiver);
        layout.addComponent(upload);
    }

    class UploadReceiver implements Upload.Receiver, Upload.ProgressListener,
            Upload.StartedListener, Upload.FinishedListener {

        private final ProgressIndicator indicator;

        public UploadReceiver(ProgressIndicator indicator) {
            this.indicator = indicator;
        }

        @Override
        public OutputStream receiveUpload(String filename, String mimeType) {
            FileOutputStream fos = null;
            try {
                File file = new File(filename);
                fos = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                Notification.show(e.getMessage(),
                        Notification.Type.ERROR_MESSAGE);
                return null;
            }
            return fos;
        }

        @Override
        public void updateProgress(long readBytes, long contentLength) {
            try {
                // let's slow down upload a bit (so we can see the progress on
                // local machine)
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            float newValue = readBytes / (float) contentLength;
            System.out.println(newValue);
            indicator.setValue(newValue);
        }

        @Override
        public void uploadStarted(Upload.StartedEvent event) {
            layout.addComponent(indicator);
            Notification.show("Upload started.", Notification.Type.TRAY_NOTIFICATION);
        }

        @Override
        public void uploadFinished(Upload.FinishedEvent event) {
            layout.removeComponent(indicator);
            Notification.show("Upload finished.", Notification.Type.TRAY_NOTIFICATION);
        }
    }
}
