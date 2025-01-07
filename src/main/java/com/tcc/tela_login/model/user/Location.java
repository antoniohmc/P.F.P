package com.tcc.tela_login.model.user;

import com.tcc.tela_login.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private Country country;
}
