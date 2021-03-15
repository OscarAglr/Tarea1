/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ni.uni.edu.programacion.views.panels.PnlMoneda;

/**
 *
 * @author Sistemas-05
 */
public class MoneyController implements ActionListener {
    private PnlMoneda pnlMoneda;

    public MoneyController(PnlMoneda pnlMoneda) {
        this.pnlMoneda = pnlMoneda;
        initComponent();
    }

    private void initComponent(){
        pnlMoneda.getBtnCalc().addActionListener(this);
        pnlMoneda.getBtnNew().addActionListener(this);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Calcular")){
            double m;
            m = Double.parseDouble(pnlMoneda.getTxtNumber1().getText());
            pnlMoneda.getTxtResult().setText(String.valueOf(conversion(m)));
        }else if(e.getActionCommand().equalsIgnoreCase("Nuevo")){
            pnlMoneda.getTxtNumber1().setText("");
            pnlMoneda.getTxtResult().setText("");
            pnlMoneda.getTxtNumber1().requestFocus();
        }
    }
    
    private double conversion(double m){
        double result = 0;
        if (pnlMoneda.getjComboBox1().getSelectedItem().toString() == "Cordoba a Dolar") {
            result = m / 35;
        } else if (pnlMoneda.getjComboBox1().getSelectedItem().toString() == "Dolar a Cordoba") {
            result = m * 35;
        }
        return result;
    }
   
    
}
