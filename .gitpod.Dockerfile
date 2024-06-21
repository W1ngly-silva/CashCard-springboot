FROM gitpod/workspace-full

USER gitpod

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
            sdk install java 17.0.9-zulu && \
            sdk default java 17.0.9-zulu && \
            sdk install gradle 8.8 && \
            sdk default gradle 8.8"