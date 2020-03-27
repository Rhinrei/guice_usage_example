package models;

import com.google.gson.annotations.SerializedName;
import org.assertj.core.api.SoftAssertions;

public class User {

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("id")
    private int id;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("email")
    private String email;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return
                "User{" +
                        "last_name = '" + lastName + '\'' +
                        ",id = '" + id + '\'' +
                        ",avatar = '" + avatar + '\'' +
                        ",first_name = '" + firstName + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(id).isEqualTo(user.id);
		softly.assertThat(lastName).isEqualTo(user.lastName);
		softly.assertThat(firstName).isEqualTo(user.firstName);
        softly.assertThat(email).isEqualTo(user.email);
		softly.assertAll();
		return true;
	}
}