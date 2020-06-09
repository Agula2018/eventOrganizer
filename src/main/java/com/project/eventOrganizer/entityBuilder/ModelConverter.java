package com.project.eventOrganizer.entityBuilder;

import java.util.List;

public interface ModelConverter<M, V> {

    M convert(V view);
    List<V> convert(List<M> modelList);

}
