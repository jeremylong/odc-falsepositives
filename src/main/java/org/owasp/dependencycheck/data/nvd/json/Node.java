
package org.owasp.dependencycheck.data.nvd.json;

import java.util.ArrayList;
import java.util.List;


/**
 * Defines a node or sub-node in an NVD applicability statement.
 * 
 */
public class Node {


    private String operator;
    private Boolean negate;
    private List<Node> children = new ArrayList<Node>();


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Boolean getNegate() {
        return negate;
    }

    public void setNegate(Boolean negate) {
        this.negate = negate;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

}
