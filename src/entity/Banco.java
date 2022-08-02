/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Jeferson Labout
 */

import java.util.List;
import lombok.Data;

public @Data class Banco {

	private String nome;
	private List<Conta> contas;

	
}
