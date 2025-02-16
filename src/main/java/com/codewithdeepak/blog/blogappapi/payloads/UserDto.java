package com.codewithdeepak.blog.blogappapi.payloads;









import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int id;
	
    @NotEmpty
    @Size(min=4,message="Username must be 4 characters")
	private String name;
	
	@Email(message="email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3 , max= 10,message="password must be min 3 character and max 10 character")
	private String password;
	
	@NotNull@NotBlank
	private String about;

}
