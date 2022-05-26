package Persistence.DTO;

import java.util.Date;

public class Announcement {
    public int announcementId;
    public String announcementTitle;
    public String announcementContent;
    public int announcementWriterId;
    public String announcementWriterName;
    public int hits;
    public int isAttachedFile;
    public Date writeDate;

    public Announcement(String announcementTitle, String announcementContent, int announcementWriterId, String announcementWriterName, int hits, int isAttachedFile, Date writeDate) {
        this.announcementTitle = announcementTitle;
        this.announcementContent = announcementContent;
        this.announcementWriterId = announcementWriterId;
        this.announcementWriterName = announcementWriterName;
        this.hits = hits;
        this.isAttachedFile = isAttachedFile;
        this.writeDate = writeDate;
    }

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
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

    public int getAnnouncementWriterId() {
        return announcementWriterId;
    }

    public void setAnnouncementWriterId(int announcementWriterId) {
        this.announcementWriterId = announcementWriterId;
    }

    public String getAnnouncementWriterName() {
        return announcementWriterName;
    }

    public void setAnnouncementWriterName(String announcementWriterName) {
        this.announcementWriterName = announcementWriterName;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getIsAttachedFile() {
        return isAttachedFile;
    }

    public void setIsAttachedFile(int isAttachedFile) {
        this.isAttachedFile = isAttachedFile;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
}
