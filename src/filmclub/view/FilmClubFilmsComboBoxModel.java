/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmclub.view;

import filmclub.model.Language;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author gabag
 */
public class FilmClubFilmsComboBoxModel extends AbstractListModel implements ComboBoxModel {
    
    private final List<Language> languages;
    
    private String selectedItem;
    
    public FilmClubFilmsComboBoxModel(List<Language> languages) {
        this.languages = new ArrayList<>(languages);
    }

    @Override
    public int getSize() {
        return languages.size();
    }

    @Override
    public Object getElementAt(int index) {
        return languages.get(index).getName();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        for (Language l: languages) {
            if (anItem.equals(l.getName())) {
                selectedItem = l.getName();
                break;
            }
        }
        
        fireContentsChanged(this, 0, 0);
    }
    
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
    public Language getLanguageAt(int index) {
        return languages.get(index);
    }
    
}
