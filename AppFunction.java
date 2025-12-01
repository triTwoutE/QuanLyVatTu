/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyvattu;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author colan
 */
// Day la cau lenh thuc hien voi Class SQLFunction;
public class AppFunction {
    private SQLFunction sqlFunction;
    private Action action;
   
    public List<VatTu> getAllVatTu() {
        sqlFunction = new SQLFunction();
        try {
            return sqlFunction.getAllVatTu();
        } catch (SQLException ex) {
            System.getLogger(AppFunction.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    
    public VatTu getVattuById(String id){
        sqlFunction = new SQLFunction();
        return sqlFunction.getVattuById(id);
    }
    public boolean existsById(String id){
        sqlFunction = new SQLFunction();
        return sqlFunction.existsById(id);
    }
    
    public void addVatTu(VatTu vattu){
        sqlFunction = new SQLFunction();
        sqlFunction.addVatTu(vattu);
        
    }
    
    public void delVatTu(String id){
        sqlFunction = new SQLFunction();
        VatTu vattu;
        vattu = sqlFunction.getVattuById(id);       
        sqlFunction.delVatTu(id);
        
    }
    
    public void updateVatTu(VatTu vattu){
        sqlFunction = new SQLFunction();
        sqlFunction.updateVatTu(vattu);
        
    }
    
     public void closeVattu(){
        sqlFunction = new SQLFunction();
        sqlFunction.closeVattu();
    }
     
     public void undo(){   
         if (!Action.undoStack.isEmpty()){
            action = Action.undoStack.pop();
           //Push Action vua undo vao redoStack:
           Action.redoStack.push(action);
           //Undo process:

           switch (action.getActionType()){
               case "Add":
                   
                   delVatTu(action.getNewVattu().getId());
                   break;
               case "Del":
                   
                   addVatTu(action.getOldVattu());
                   break;
               case "Update":
                   
                   updateVatTu(action.getOldVattu());
                   break;
           }
        }
     }
     
     public void redo(){   
         if (!Action.redoStack.isEmpty()){
            action = Action.redoStack.pop();
           //Push Action vua redo vao undoStack:
           Action.undoStack.push(action);
           //Redo process:

           switch (action.getActionType()){
               case "Del":
                   
                   delVatTu(action.getOldVattu().getId());
                   break;
               case "Add":
                   
                   addVatTu(action.getNewVattu());
                   break;
               case "Update":
                   
                   updateVatTu(action.getNewVattu());
                   break;
           }
        }
     }
}
