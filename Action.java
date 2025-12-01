/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyvattu;

import java.util.Stack;

/**
 *
 * @author colan
 */
public class Action {
    private String ActionType;
    private VatTu oldVattu;
    private VatTu newVattu;
    
    public static Stack<Action> undoStack = new Stack<>();
    public static Stack<Action> redoStack = new Stack<>();
    
    public Action(){};
    public Action(String ActionType, VatTu oldVattu, VatTu newVattu){
        this.ActionType = ActionType;
        this.newVattu = newVattu;
        this.oldVattu = oldVattu;
    }
    
    public String getActionType(){
        return ActionType;
    }
    public void setActionType(String ActionType){
        this.ActionType = ActionType;
    }
    
    public VatTu getOldVattu(){
        return oldVattu;
    }
    public void setOldVattu(VatTu oldVattu){
        this.oldVattu = oldVattu;
    }
    
    public VatTu getNewVattu(){
        return newVattu;
    }
    public void setNewVattu(VatTu newVattu){
        this.newVattu = newVattu;
    }
    
//    public Action reverseActtion(){
//        Action reverseActtion = new Action();
//        switch (this.ActionType){
//            case "Add":
//                reverseActtion.ActionType = "Del";
//                break;
//            case "Del":
//                reverseActtion.ActionType = "Add";
//                break;
//            
//        }
//        reverseActtion.newVattu = this.oldVattu;
//        reverseActtion.oldVattu = this.newVattu;
//        return reverseActtion;
//    }
}
