package io.kimmking.rpcfx.demo.consumer;

import io.kimmking.rpcfx.annotation.Rpc;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
@Configuration
public class ClientAnnotation implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //annotationMetadata.getAnnotationAttributes(Rpc.class.getName())
//        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//        String basePackage = "io.kimmking.rpcfx.demo.*";
//        basePackage = basePackage.replace(".", "/")+  "/" + "**/*.class";
//        try {
//            Resource[] resources = resourcePatternResolver.getResources("classpath*:" + basePackage);
//            MetadataReaderFactory metadata1 = new SimpleMetadataReaderFactory();
//            for (Resource resource : resources) {
//                MetadataReader metadataReader = null;
//                try {
//                    metadataReader = metadata1.getMetadataReader(resource);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                if(metadataReader.getAnnotationMetadata().hasAnnotation(Rpc.class.getName())){
//                    ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition(metadataReader);
//                    sbd.setResource(resource);
//                    sbd.setSource(resource);
//                    sbd.setBeanClass(RpcFactory.class);
//                    sbd.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
//                    beanDefinitionRegistry.registerBeanDefinition(metadataReader.getClassMetadata().getClassName(),sbd);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        RpcPackageScanHandle scanHandle = new RpcPackageScanHandle(beanDefinitionRegistry,false);
        scanHandle.scan("io.kimmking.rpcfx.demo");
    }


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
