package Persistence.DTO;

import java.util.Date;

public class AnnouncementDTO {
    private String announcementId;
    private String announcementTitle;
    private String announcementContent;
    //private int announcementWriterId;
    private String announcementWriterName;
    private Date writeDate;
    private int isAttachedFile;
    private int hits;

    public AnnouncementDTO(String announcementTitle, String announcementContent, String announcementWriterName, Date writeDate, int isAttachedFile, int hits) {
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
        this.announcementWriterName = announcementWriterName;
        this.writeDate = writeDate;
        this.isAttachedFile = isAttachedFile;
        this.hits = hits;
    }


    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public String getAnnouncementWriterName() {
        return announcementWriterName;
    }

    public void setAnnouncementWriterName(String announcementWriterName) {
        this.announcementWriterName = announcementWriterName;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public int getIsAttachedFile() {
        return isAttachedFile;
    }

    public void setIsAttachedFile(int isAttachedFile) {
        this.isAttachedFile = isAttachedFile;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
