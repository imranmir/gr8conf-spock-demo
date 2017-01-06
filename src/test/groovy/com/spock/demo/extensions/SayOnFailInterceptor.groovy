package com.spock.demo.extensions

import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo

/**
 * Created by imran on 04/01/17.
 */
class SayOnFailInterceptor implements IMethodInterceptor {

    SayOnFail sayOnError
    FeatureInfo featureInfo

    SayOnFailInterceptor(SayOnFail sayOnError, FeatureInfo featureInfo) {
        this.sayOnError = sayOnError
        this.featureInfo = featureInfo
    }

    @Override
    void intercept(IMethodInvocation invocation) throws Throwable {
        try {
            invocation.proceed()
        } catch (Throwable t) {
            def methodName = featureInfo.getFeatureMethod().name
            def voiceName = sayOnError.voice()
            def sayText = sayOnError.value() ?: "Danger! Failure for: $methodName"
            try {
                "say -v $voiceName $sayText".execute()
            } catch (IOException ex) {
                println "an xception here again "+ex
            }
            throw t
        }
    }
}
