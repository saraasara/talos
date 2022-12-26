package com.talosvfx.talos.editor.addons.scene.apps.routines.runtime.nodes;

import com.badlogic.gdx.utils.JsonValue;
import com.talosvfx.talos.editor.addons.scene.apps.routines.runtime.RoutineInstance;
import com.talosvfx.talos.editor.addons.scene.apps.routines.runtime.RoutineNode;
import com.talosvfx.talos.editor.addons.scene.utils.propertyWrappers.PropertyWrapper;

public class ExposedVariableNode extends RoutineNode {

    public int index;

    private transient PropertyWrapper<?> propertyWrapper;

    public void updateForPropertyWrapper (PropertyWrapper<?> propertyWrapper) {
        if (propertyWrapper != null) {
            index = propertyWrapper.index;
            this.propertyWrapper = propertyWrapper;
        }
    }
    @Override
    public Object queryValue (String targetPortName) {
        if (propertyWrapper == null) {
            return null;
        }

        return propertyWrapper.value;
    }

    @Override
    public void loadFrom (RoutineInstance routineInstance, JsonValue nodeData) {
        super.loadFrom(routineInstance, nodeData);
        index = nodeData.getInt("index", 0);
        propertyWrapper = routineInstance.getPropertyWrapperWithIndex(index);
    }

    @Override
    protected void configureNode (JsonValue properties) {

    }
}
