package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by Prog on 14.09.2016.
 */
public abstract class CollisionObject extends GameObject
{
    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){

        switch (direction){
            case UP: {
                if (gameObject.getX() == getX() && gameObject.getY() == getY() - Model.FIELD_SELL_SIZE){
                    return true;
                }
                else
                {
                    return false;
                }

            }
            case DOWN: {
                if (gameObject.getX() == getX() && gameObject.getY() == getY() + Model.FIELD_SELL_SIZE){
                    return true;
                }
                else
                {
                    return false;
                }

            }
            case LEFT: {
                if (gameObject.getX() == getX() - Model.FIELD_SELL_SIZE && gameObject.getY() == getY()){
                    return true;
                }
                else
                {
                    return false;
                }

            }
            case RIGHT: {
                if (gameObject.getX() == getX() + Model.FIELD_SELL_SIZE && gameObject.getY() == getY()){
                    return true;
                }
                else
                {
                    return false;
                }

            }


            default:{
                return false;
            }

        }

    }
}
