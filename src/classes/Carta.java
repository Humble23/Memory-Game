/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author 20152134110070
 */
public class Carta {
  public String [] imagens = new String[11];
  public String [] imagensB = new String[11];
  
  public String pegaImagePorId (int id){
      return this.imagens [id];
  }
}
