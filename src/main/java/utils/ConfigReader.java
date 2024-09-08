package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private final String propertyFilePath = "config.properties";

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(propertyFilePath);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found at " + propertyFilePath);
        }
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getSubredditUrl() {
        return properties.getProperty("subreddit_url");
    }

    public String getRedditUrl(){
        return properties.getProperty("reddit_url");
    }
    public String getsearchData(){
        return properties.getProperty("searchData");
    }
    public String getHomePageUrl(){
        return properties.getProperty("homePageUrl");
    }
    public String getPost_title(){
        return properties.getProperty("post_title");
    }
    public String getPostBody(){
        return properties.getProperty("postBody");
    }
    public String createPostURL()
    {
        return properties.getProperty("createPostUrl");
    }
}
