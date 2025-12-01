/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyvattu;

/**
 *
 * @author colan
 */
public class InputValidator {
    public static String validCheck(String id, String name, String amount, String unit, String category){
       //Check ID (Chưa kiểm tra ID trùng vì sẽ làm tại AppFunction)
       if (id.isBlank()) return "Ban khong the de ID trong!";
       if (id.length() > 6) return "ID vat tu qua dai (<=6)!";
       
       //Check name:
       if (name.length() > 100) return "Ten vat tu qua dai (<=100)!";
       if (name.isBlank()) return "Ban khong the de ten trong!";
       
       //Check Amount:
       if (!amount.matches("\\d+")) return "So luong vat tu nhap vao khong hop le!";
       if (Integer.parseInt(amount) < 0) return "So luong vat tu nhap vao khong hop le!";
       
       //Check unit:
       if (unit.length() > 40) return "Don vi qua dai (<=40)!";
       
       //Check category: 
        if (category.length() > 100) return "Ten vat tu qua dai (<=100)!";
        
        return null;
        
    }
}