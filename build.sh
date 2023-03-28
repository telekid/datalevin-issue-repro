#!/usr/bin/env sh

export USE_NATIVE_IMAGE_JAVA_PLATFORM_MODULE_SYSTEM=false
export DTLV_COMPILE_NATIVE=true

clj -T:build uberjar

"$GRAALVM_HOME/bin/native-image" \
    --features=InitAtBuildTimeFeature \
    -jar target/example.jar example
