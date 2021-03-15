/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ni.uni.edu.programacion.views.panels.PnlTemperatura;

/**
 *
 * @author Sistemas-05
 */
public class TemperatureController implements ActionListener {
    private PnlTemperatura pnlTemperatura;

    public TemperatureController(PnlTemperatura pnlTemperatura) {
        this.pnlTemperatura = pnlTemperatura;
        initComponent();
    }

    private void initComponent(){
        pnlTemperatura.getBtnCalc().addActionListener(this);
        pnlTemperatura.getBtnNew().addActionListener(this);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Calcular")){
            double t;
            t = Double.parseDouble(pnlTemperatura.getTxtNumber1().getText());
            pnlTemperatura.getTxtResult().setText(String.valueOf(conversion(t)));
        }else if(e.getActionCommand().equalsIgnoreCase("Nuevo")){
            pnlTemperatura.getTxtNumber1().setText("");
            pnlTemperatura.getTxtResult().setText("");
            pnlTemperatura.getTxtNumber1().requestFocus();
        }
    }
    
    private double conversion(double t){
        double result = 0;
        if (pnlTemperatura.getjComboBox1().getSelectedItem().toString() == "Celsius a Fahrenheit") {
            result = (t * 9/5) + 32;
        } else if (pnlTemperatura.getjComboBox1().getSelectedItem().toString() == "Fahrenheit a Celsius") {
            result = (t - 32) * 5/9;
        }
        return result;
    }
   
    
}
