package ru.thstdio.study.poplib.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void setButtonOneValue(int value);

    void setButtonTwoValue(int value);

    void setButtonTreeValue(int value);

    void setImageColor(int color);
}
