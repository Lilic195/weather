package grafika;

import com.google.gson.Gson;
import klase.Drzava;
import klase.Grad;
import klase.Prognoza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Aleksa on 13-Jan-17.
 */
public class Prozor extends JFrame {
    private  Drzava[] listaDrzava;
    private Grad[] listaGradova;
    private Prognoza prognoza;

    public Prozor(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Vremenska prognoza");
        setSize(1000,300);
        setLayout(null);

        Gson gson = new Gson();
        try {
            BufferedReader drzave = new BufferedReader(new FileReader("C:\\Users\\aleks\\Lilic\\Programming\\OBJ2\\Weather\\src\\data.json"));
            BufferedReader gradovi = new BufferedReader(new FileReader("C:\\Users\\aleks\\Lilic\\Programming\\OBJ2\\Weather\\src\\world-cities.json"));

            listaDrzava = gson.fromJson(drzave, Drzava[].class);
            listaGradova = gson.fromJson(gradovi, Grad[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        init();
        setVisible(true);
    }

    private void init(){
        JComboBox<Drzava> drzave = new JComboBox<Drzava>();
        JComboBox<Grad> gradovi = new JComboBox<Grad>();
        JLabel odgovor = new JLabel();
        odgovor.setFont (odgovor.getFont ().deriveFont (64.0f));

        for (Drzava item: listaDrzava) {
            drzave.addItem(item);
        }
        drzave.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Drzava drzava = (Drzava)drzave.getSelectedItem();
                gradovi.removeAllItems();
                for (Grad item: listaGradova) {
                    if(item.getCountry().equals(drzava.getName())) {
                        gradovi.addItem(item);
                    }
                }

            }
        });


        drzave.setBounds(10,10,200,30);
        gradovi.setBounds(220,10,300,30);
        odgovor.setBounds(10,50,900,100);

        JButton vreme = new JButton("Prognoza");

        vreme.setBounds(530,10,100,30);
        vreme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Drzava drzava =(Drzava) drzave.getSelectedItem();
               Grad grad = (Grad) gradovi.getSelectedItem();
               prognoza = new Prognoza(grad.getName().replaceAll("\\s",""),drzava.getCode());
               odgovor.setText(prognoza.request());
            }
        });

        add(odgovor);
        add(vreme);
        add(gradovi);
        add(drzave);

    }
}
