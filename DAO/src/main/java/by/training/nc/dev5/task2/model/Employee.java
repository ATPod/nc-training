/**
 * 
 */
package employee.training.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author GEG.BY
 *
 */
public class Employee {

	private int mId;
	private String mFirstName;
	private String mLastName;
	private String mEmail;
	private Set<Training> mTrainings = new HashSet<Training>();
	
	public int getId() {
		return mId;
	}
	public void setId(int pId) {
		mId = pId;
	}
	public String getFirstName() {
		return mFirstName;
	}
	public void setFirstName(String pFirstName) {
		mFirstName = pFirstName;
	}
	public String getmLastName() {
		return mLastName;
	}
	public void setLastName(String pLastName) {
		mLastName = pLastName;
	}
	public String getEmail() {
		return mEmail;
	}
	public void setEmail(String pEmail) {
		mEmail = pEmail;
	}
	public Set<Training> getTrainings() {
		return mTrainings;
	}
	public void setTrainings(Set<Training> pTrainings) {
		mTrainings = pTrainings;
	}
	
	
}
