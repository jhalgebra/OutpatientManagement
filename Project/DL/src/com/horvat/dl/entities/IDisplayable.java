package com.horvat.dl.entities;

import java.util.List;
import java.util.Map;

public interface IDisplayable {
    String NON_GROUPED_NAME = "Data";

    Map<String, Map<String, Object>> getDisplayDataGroups();

    Map<String, List<? extends IDisplayable>> getInnerData();
}
