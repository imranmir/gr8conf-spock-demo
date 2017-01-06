package com.spock.demo.extensions

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

/**
 * Created by imran on 04/01/17.
 */
class SayOnFailExtension extends AbstractAnnotationDrivenExtension<SayOnFail> {


    @Override
    void visitSpecAnnotation(SayOnFail sayOnError, SpecInfo spec) {
        spec.features.each { FeatureInfo feature ->
            if (!feature.featureMethod.reflection.isAnnotationPresent(SayOnFail)) {
                visitFeatureAnnotation(sayOnError, feature)
            }
        }
    }

    @Override
    void visitFeatureAnnotation(SayOnFail sayOnError, FeatureInfo feature) {
        def interceptor = new SayOnFailInterceptor(sayOnError, feature)
        feature.getFeatureMethod().addInterceptor(interceptor)
    }
}