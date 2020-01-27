package com.exercise4.media;

public class Media {

    private Integer id;
    private String name;
    private String url;
    private Integer videoLength;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws Exception {
        if(id < 0 || id > (Math.pow(10,7)) || id == null){
            throw new Exception();
        }else{
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name == null || name.length() > 512){
            throw new Exception();
        }else{
            this.name = name;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) throws Exception {
        if(url.length() > 512) {
            throw new Exception();
        }else{
            this.url = url;
        }
    }

    public Integer getVideoLength() { return videoLength; }

    public void setVideoLength(Integer videoLength) throws Exception {
        if(videoLength >= (Math.pow(10,7)) || videoLength < 0) {
            throw new Exception();
        }else{
            this.videoLength = videoLength;
        }
    }

    public Media(Integer id, String name, String url,Integer videoLength) throws Exception{
        try{
            setId(id);
            setName(name);
            setUrl(url);
            setVideoLength(videoLength);
        }catch (Exception e){
            System.out.print("Não foi possível inserir a mídia.");
            throw new Exception();

        }
    }
}
