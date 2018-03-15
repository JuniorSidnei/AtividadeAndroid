package com.example.aluno.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALUNO on 14/03/2018.
 */

class ResourceManager {
    private static final ResourceManager ourInstance = new ResourceManager();

    static ResourceManager getInstance() {
        return ourInstance;
    }

    private ResourceManager() {}

    public List<GameObject> gameObjects = new ArrayList<>();

    public void addObject(GameObject object)
    {
        for(int i = 0; i < gameObjects.size(); i++)
        {
            if(object.layer < gameObjects.get(i).layer)
            {
                gameObjects.add(i, object);
                return;
            }
        }
        gameObjects.add(object);
    }
}
