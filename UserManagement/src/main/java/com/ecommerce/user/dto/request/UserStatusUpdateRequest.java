package com.ecommerce.user.dto.request;

import com.ecommerce.user.enums.AccountStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStatusUpdateRequest {

	@NotNull(message = "Account status is required")
	private AccountStatus accountStatus;
}
