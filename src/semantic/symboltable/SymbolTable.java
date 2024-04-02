package semantic.symboltable;

import ast.definitions.Definition;

import java.util.*;

public class SymbolTable {

    private int scope = 0;

    private List<Map<String, Definition>> st;

    public SymbolTable() {
        st = new ArrayList<Map<String, Definition>>();
        st.add(new HashMap<String, Definition>()); // global scope (0)
    }

    // A new Map is created and added when a new scope is opened
    public void set() {
        st.add(new HashMap<String, Definition>());
        this.scope++; // local scope (1)
    }

    // The last Map is deleted when the scope is closed
    public void reset() {
        st.remove(scope);
        this.scope--;
    }

    // Returns false if the variable was already defined
    public boolean insert(Definition node) {
        Definition definition = findInCurrentScope(node.getName());

        // Variable defined in the current scope
        if(definition != null)
            return false;

        // Variable added in the current scope
        st.get(this.scope).put(node.getName(), node);
        node.setScope(this.scope);
        return true;
    }

    public Definition find(String id) {
        // From the current most nested scope to the global
        for(int i = scope; i >= 0; i--)
            if(st.get(i).containsKey(id))
                return st.get(i).get(id);   // defined

        return null;    // NOT defined
    }

    public Definition findInCurrentScope(String id) {
        if(st.get(this.scope).containsKey(id))
            return st.get(this.scope).get(id);  // defined

        return null; // NOT defined
    }
}
