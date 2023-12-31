package me.jaehoon.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> autoConfigs = new ArrayList<>();
//        for(String candidate : ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//            autoConfigs.add(candidate);
//        }
//        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);
//        return autoConfigs.toArray(new String[0]);

        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);
        return autoConfigs.stream().toArray(String[]::new);
    }
}
