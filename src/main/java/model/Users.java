package model;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import org.hibernate.annotations.Columns;

@Entity
public class Users {

	public enum PermissionType {
		ADMIN, MANAGER, USER;

	}

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String name;
	private String psw;
	private PermissionType permission;

	public Users() {

	}

	public Users(String name, String psw) {
		this.name = name;
		this.psw = psw;
	}

	public Users(String name, String psw, String permission) {
		this.name = name;
		this.psw = psw;
		this.permission = PermissionType.valueOf(permission);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public PermissionType getPermission() {
		return permission;
	}

	public void setPermission(PermissionType permission) {
		this.permission = permission;
	}

	public void convertStringToPermission(String s) {
		if (s == "") {
			s = null;
			this.permission = null;
		} else
			this.permission = PermissionType.valueOf(s.toUpperCase());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, psw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(name, other.name) && Objects.equals(psw, other.psw);
	}

	@Override
	public String toString() {
		return "User:\nid=" + id + "\nname=" + name + "\npsw=" + psw + "\npermission=" + permission + "";
	}

}
