/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author julza
 */
public class CollectionDateAdjustments {
    private String id;
    private String UserId;
    private String DateAssigned;
    private String Notes;
    private String Status;
    private String AssignedBy;

    public CollectionDateAdjustments() {
    }

    public CollectionDateAdjustments(String id, String UserId, String DateAssigned, String Notes, String Status, String AssignedBy) {
        this.id = id;
        this.UserId = UserId;
        this.DateAssigned = DateAssigned;
        this.Notes = Notes;
        this.Status = Status;
        this.AssignedBy = AssignedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getDateAssigned() {
        return DateAssigned;
    }

    public void setDateAssigned(String DateAssigned) {
        this.DateAssigned = DateAssigned;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAssignedBy() {
        return AssignedBy;
    }

    public void setAssignedBy(String AssignedBy) {
        this.AssignedBy = AssignedBy;
    }
    
    
}
