package org.dependencycheck.testing;

import java.io.IOException;

public class HtmlUtil {

    public String bold(String c) {

        return String.format("<b>%s</b>", c);
    }
    
        public String execute(String c) 
            throws IOException {
        String cmd = "sh " + c;
        Runtime.getRuntime().exec(cmd);
        return cmd;
    }
}
