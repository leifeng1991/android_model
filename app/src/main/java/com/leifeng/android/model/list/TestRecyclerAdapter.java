package com.leifeng.android.model.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cnlive.module.base.utils.LogUtil;
import com.leifeng.android.model.R;
import com.leifeng.android.model.databinding.User;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.TestViewHolder> {
    private static final String TAG = TestRecyclerAdapter.class.getSimpleName();
    private static final int STYLE = 0;
    private static final int STYLE_1 = 1;
    private static final int STYLE_2 = 2;
    private static final int STYLE_3 = 3;
    private static final int STYLE_4 = 4;
    private static final int STYLE_5 = 5;

    private Context mContext;
    private List<User> list = new ArrayList<>();
    private List<User> oldList = new ArrayList<>();

    public TestRecyclerAdapter(Context mContext, List<User> list) {
        this.mContext = mContext;
        this.list.addAll(list);
        this.oldList.addAll(list);
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.e(TAG, "========================onCreateViewHolder" + i);
        View view;
        switch (i) {
            case STYLE_1:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_test_layout_1, viewGroup, false);
                break;
            case STYLE_2:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_test_layout_2, viewGroup, false);
                break;
            case STYLE_3:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_test_layout_3, viewGroup, false);
                break;
            case STYLE_4:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_test_layout_4, viewGroup, false);
                break;
            case STYLE_5:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_test_layout_5, viewGroup, false);
                break;
            default:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_test_layout, viewGroup, false);
                break;
        }
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder testViewHolder, int i) {
        Log.e(TAG, "========================onBindViewHolder" + i);
        testViewHolder.mTextView.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return STYLE_1;
            case 1:
                return STYLE_2;
            case 2:
                return STYLE_3;
            case 3:
                return STYLE_4;
            case 4:
                return STYLE_5;
            default:
                return STYLE;
        }
    }

    class TestViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        TestViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.mTextView);
        }
    }

    public void updateList(final List<User> newList) {

        User user = list.get(1);
        user.setName("变化了");
        list.set(1, user);

        Log.e(TAG, "===============######" + list.get(1).toString() + "===" + oldList.get(1).toString());

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return oldList.size();
            }

            @Override
            public int getNewListSize() {
                return list.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                boolean r = oldList.get(oldItemPosition) == list.get(newItemPosition);
                Log.e(TAG, "========================areItemsTheSame==" + r);
                return r;
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                User oldUser = oldList.get(oldItemPosition);
                User newUser = list.get(newItemPosition);
                Log.e(TAG, "========================areContentsTheSame==" + oldUser.getName() + "==" + newUser.getName());
                boolean r = oldUser.getName().equals(newUser.getName());
                Log.e(TAG, "========================areContentsTheSame==" + r);
                return r;
            }

            @Nullable
            @Override
            public Object getChangePayload(int oldItemPosition, int newItemPosition) {
                Log.e(TAG, "========================getChangePayload==");
                return super.getChangePayload(oldItemPosition, newItemPosition);
            }
        });
        Log.e(TAG, "========================areContentsTheSame==*******************");
        oldList = list;
        diffResult.dispatchUpdatesTo(this);
    }
}
