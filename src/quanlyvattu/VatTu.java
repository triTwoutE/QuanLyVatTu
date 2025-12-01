/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyvattu;

/**
 *
 * @author colan
 */
public class VatTu {
    private String id;
    private String name;
    private int amount;
    private String unit;
    private String category;
    
    //ID
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    //Name
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    //Amount
    public int getAmount(){
        return this.amount;
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }
    
    //Unit
    public String getUnit(){
        return this.unit;
    }
    
    public void setUnit(String unit){
        this.unit = unit;
    }
    
    //Category
    public String getCategory(){
        return this.category;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public String toString(){
        return id + " " + name + " " + amount + " " + unit + " " + category ; 
    }
    
}
