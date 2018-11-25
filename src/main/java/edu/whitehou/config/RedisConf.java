package edu.whitehou.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.whitehou.entity.User;
import edu.whitehou.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.cache.CacheManager;
import java.time.Duration;

/**
 * @author : white.hou
 * @description : redis 的自定义序列化配置  来自RedisAutoConfiguration
 * @date: 2018/11/23_14:49
 */
@Configuration
public class RedisConf {
    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
/*        Jackson2JsonRedisSerializer userJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        userJackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        // 设置value的序列化规则和 key的序列化规则
        template.setValueSerializer(userJackson2JsonRedisSerializer);
        template.setHashValueSerializer(userJackson2JsonRedisSerializer);
        template.setKeySerializer(userJackson2JsonRedisSerializer);
        template.setHashKeySerializer(template.getKeySerializer());
        template.afterPropertiesSet();
        return template;*/
        Jackson2JsonRedisSerializer<User> userJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<User>(User.class);
        template.setDefaultSerializer(userJackson2JsonRedisSerializer);
        return template;
    }
    @Bean(name = "userRedisCacheManager")
    public RedisCacheManager userRedisCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .builder(redisConnectionFactory);
        return builder.build();
    }
}
