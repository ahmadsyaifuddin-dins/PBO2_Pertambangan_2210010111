/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import javax.swing.JTextField;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 *
 * @author User
 */
public class dynamic {
    private Map<String, JTextField> fieldMap;
    
    public dynamic() {
        fieldMap = new LinkedHashMap<>(); // LinkedHashMap untuk menjaga urutan field
    }
    
    // Menambahkan pasangan field dan component
    public void addField(String fieldName, JTextField component) {
        fieldMap.put(fieldName, component);
    }
    
    // Mendapatkan array nama field
    public String[] getFieldNames() {
        return fieldMap.keySet().toArray(new String[0]);
    }
    
    // Mendapatkan array values
    public String[] getFieldValues() {
        return fieldMap.values().stream()
                      .map(JTextField::getText)
                      .toArray(String[]::new);
    }
    
    // Mengecek apakah ada field yang kosong
    public boolean hasEmptyFields() {
        return fieldMap.values().stream()
                      .anyMatch(field -> field.getText().trim().isEmpty());
    }
}
