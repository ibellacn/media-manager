package com.exercise4.media;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("mediaService")
public class MediaService {
    List<Media> mediaList = new ArrayList<Media>();
    Media media;

    public Media create(String name, String url, Integer videolength) throws Exception{
        try{
            media = new Media((mediaList.size() + 1),name,url,videolength);
            mediaList.add(media);
        }catch (Exception e){
            return null;
        }
        return media;
    }

    public Media search(Integer id){
        for(Media media : mediaList){
            if(media.getId() == id){
                return media;
            }
        }
        return null;
    }

    public List<Media> mediaList(){
        return mediaList;
    }
}
