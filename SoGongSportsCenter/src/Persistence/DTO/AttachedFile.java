package Persistence.DTO;

import java.sql.Blob;

public class AttachedFile {
    public int attachedFileId;
    public int announcementId;
    public Blob attachedFile;

    public int getAttachedFileId() {
        return attachedFileId;
    }

    public void setAttachedFileId(int attachedFileId) {
        this.attachedFileId = attachedFileId;
    }

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public Blob getAttachedFile() {
        return attachedFile;
    }

    public void setAttachedFile(Blob attachedFile) {
        this.attachedFile = attachedFile;
    }
}
