/*
Copyright 2008-2010 Gephi
Authors : Jeremy Subtil <jeremy.subtil@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.desktop.preview.propertyeditors;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.gephi.preview.types.EdgeColor;
import org.gephi.ui.components.JColorButton;

/**
 *
 * @author Mathieu Bastian
 */
public class EdgeColorPanel extends javax.swing.JPanel implements ItemListener {

    /** Creates new form EdgeColorPanel */
    public EdgeColorPanel() {
        initComponents();

        colorButton.addPropertyChangeListener(JColorButton.EVENT_COLOR, new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                Color newColor = (Color) evt.getNewValue();
                propertyEditor.setValue(new EdgeColor(newColor));
            }
        });

        originalRadio.addItemListener(this);
        mixedRadio.addItemListener(this);
        sourceRadio.addItemListener(this);
        targetRadio.addItemListener(this);
        customRadio.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (customRadio.isSelected()) {
            colorButton.setEnabled(true);
        } else {
            colorButton.setEnabled(false);
        }
        EdgeColor.Mode selectedMode = null;
        if (originalRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.ORIGINAL;
        } else if (mixedRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.MIXED;
        } else if (sourceRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.SOURCE;
        } else if (targetRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.TARGET;
        } else if (customRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.CUSTOM;
        }
        propertyEditor.setValue(new EdgeColor(selectedMode));
    }
    private EdgeColorPropertyEditor propertyEditor;

    public void setup(EdgeColorPropertyEditor propertyEditor) {
        this.propertyEditor = propertyEditor;
        EdgeColor edgeColor = (EdgeColor) propertyEditor.getValue();
        if (edgeColor.getMode().equals(EdgeColor.Mode.CUSTOM)) {
            customRadio.setSelected(true);
            ((JColorButton) colorButton).setColor(edgeColor.getCustomColor());
        } else if (edgeColor.getMode().equals(EdgeColor.Mode.MIXED)) {
            mixedRadio.setSelected(true);
        } else if (edgeColor.getMode().equals(EdgeColor.Mode.ORIGINAL)) {
            originalRadio.setSelected(true);
        } else if (edgeColor.getMode().equals(EdgeColor.Mode.SOURCE)) {
            sourceRadio.setSelected(true);
        } else if (edgeColor.getMode().equals(EdgeColor.Mode.TARGET)) {
            targetRadio.setSelected(true);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        originalRadio = new javax.swing.JRadioButton();
        mixedRadio = new javax.swing.JRadioButton();
        sourceRadio = new javax.swing.JRadioButton();
        targetRadio = new javax.swing.JRadioButton();
        customRadio = new javax.swing.JRadioButton();
        colorButton = new JColorButton(Color.BLACK);

        jXHeader1.setDescription(org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.jXHeader1.description")); // NOI18N
        jXHeader1.setTitle(org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.jXHeader1.title")); // NOI18N

        buttonGroup1.add(originalRadio);
        originalRadio.setText(org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.originalRadio.text")); // NOI18N

        buttonGroup1.add(mixedRadio);
        mixedRadio.setText(org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.mixedRadio.text")); // NOI18N

        buttonGroup1.add(sourceRadio);
        sourceRadio.setText(org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.sourceRadio.text")); // NOI18N

        buttonGroup1.add(targetRadio);
        targetRadio.setText(org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.targetRadio.text")); // NOI18N

        buttonGroup1.add(customRadio);
        customRadio.setText(org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.customRadio.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(originalRadio)
                    .addComponent(mixedRadio)
                    .addComponent(sourceRadio)
                    .addComponent(targetRadio)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorButton)))
                .addContainerGap(323, Short.MAX_VALUE))
            .addComponent(jXHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(originalRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mixedRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sourceRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(targetRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customRadio)
                    .addComponent(colorButton))
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton colorButton;
    private javax.swing.JRadioButton customRadio;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private javax.swing.JRadioButton mixedRadio;
    private javax.swing.JRadioButton originalRadio;
    private javax.swing.JRadioButton sourceRadio;
    private javax.swing.JRadioButton targetRadio;
    // End of variables declaration//GEN-END:variables
}
