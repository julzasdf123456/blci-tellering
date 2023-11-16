/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localdb;

/**
 *
 * @author julza
 */
public class Preferences {
    private String id;
    private String Username;
    private String UserId;
    private String UserPassword;
    private String Office;
    private String OfficeCode;
    private String ServerHostName;
    private String DatabaseName;
    private String DatabaseSuperAdminUsername;
    private String DatabaseSuperAdminPassword;
    private String HostWebLink;
    private String HostWebIPAddress;

    public Preferences() {
    }

    public Preferences(String id, String Username, String UserId, String UserPassword, String Office, String OfficeCode, String ServerHostName, String DatabaseName, String DatabaseSuperAdminUsername, String DatabaseSuperAdminPassword, String HostWebLink, String HostWebIPAddress) {
        this.id = id;
        this.Username = Username;
        this.UserId = UserId;
        this.UserPassword = UserPassword;
        this.Office = Office;
        this.OfficeCode = OfficeCode;
        this.ServerHostName = ServerHostName;
        this.DatabaseName = DatabaseName;
        this.DatabaseSuperAdminUsername = DatabaseSuperAdminUsername;
        this.DatabaseSuperAdminPassword = DatabaseSuperAdminPassword;
        this.HostWebLink = HostWebLink;
        this.HostWebIPAddress = HostWebIPAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String Office) {
        this.Office = Office;
    }

    public String getOfficeCode() {
        return OfficeCode;
    }

    public void setOfficeCode(String OfficeCode) {
        this.OfficeCode = OfficeCode;
    }

    public String getServerHostName() {
        return ServerHostName;
    }

    public void setServerHostName(String ServerHostName) {
        this.ServerHostName = ServerHostName;
    }

    public String getDatabaseName() {
        return DatabaseName;
    }

    public void setDatabaseName(String DatabaseName) {
        this.DatabaseName = DatabaseName;
    }

    public String getDatabaseSuperAdminUsername() {
        return DatabaseSuperAdminUsername;
    }

    public void setDatabaseSuperAdminUsername(String DatabaseSuperAdminUsername) {
        this.DatabaseSuperAdminUsername = DatabaseSuperAdminUsername;
    }

    public String getDatabaseSuperAdminPassword() {
        return DatabaseSuperAdminPassword;
    }

    public void setDatabaseSuperAdminPassword(String DatabaseSuperAdminPassword) {
        this.DatabaseSuperAdminPassword = DatabaseSuperAdminPassword;
    }

    public String getHostWebLink() {
        return HostWebLink;
    }

    public void setHostWebLink(String HostWebLink) {
        this.HostWebLink = HostWebLink;
    }

    public String getHostWebIPAddress() {
        return HostWebIPAddress;
    }

    public void setHostWebIPAddress(String HostWebIPAddress) {
        this.HostWebIPAddress = HostWebIPAddress;
    }
    
}
