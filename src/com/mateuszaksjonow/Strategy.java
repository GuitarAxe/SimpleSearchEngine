package com.mateuszaksjonow;

import java.util.Map;
import java.util.Set;

public abstract class Strategy {

    public abstract boolean search (Map<String, Set<String>> map, String data);
}
