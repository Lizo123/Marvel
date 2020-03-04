package com.example.marvel.databinding;
import com.example.marvel.R;
import com.example.marvel.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMarvelCharacterDetailsBindingImpl extends ActivityMarvelCharacterDetailsBinding implements com.example.marvel.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 6);
        sViewsWithIds.put(R.id.image, 7);
        sViewsWithIds.put(R.id.textView, 8);
        sViewsWithIds.put(R.id.textView4, 9);
        sViewsWithIds.put(R.id.textView3, 10);
        sViewsWithIds.put(R.id.comicsRecyclerView, 11);
        sViewsWithIds.put(R.id.textView6, 12);
        sViewsWithIds.put(R.id.seriesRecyclerView, 13);
        sViewsWithIds.put(R.id.textView7, 14);
        sViewsWithIds.put(R.id.eventsRecyclerView, 15);
        sViewsWithIds.put(R.id.textView8, 16);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMarvelCharacterDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ActivityMarvelCharacterDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[15]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[16]
            , (androidx.appcompat.widget.Toolbar) bindings[6]
            , (android.widget.TextView) bindings[4]
            );
        this.comicLink.setTag(null);
        this.description.setTag(null);
        this.detailLink.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.name.setTag(null);
        this.wikiLink.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.example.marvel.generated.callback.OnClickListener(this, 3);
        mCallback1 = new com.example.marvel.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.example.marvel.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.example.marvel.models.Item) variable);
        }
        else if (BR.activity == variableId) {
            setActivity((com.example.marvel.view.marvel_details.CharacterDetailsActivity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.example.marvel.models.Item Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    public void setActivity(@Nullable com.example.marvel.view.marvel_details.CharacterDetailsActivity Activity) {
        this.mActivity = Activity;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.activity);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.marvel.models.Item model = mModel;
        java.lang.String modelDescription = null;
        java.lang.String modelName = null;
        com.example.marvel.view.marvel_details.CharacterDetailsActivity activity = mActivity;

        if ((dirtyFlags & 0x5L) != 0) {



                if (model != null) {
                    // read model.description
                    modelDescription = model.getDescription();
                    // read model.name
                    modelName = model.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.comicLink.setOnClickListener(mCallback3);
            this.detailLink.setOnClickListener(mCallback1);
            this.wikiLink.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.description, modelDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, modelName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // model
                com.example.marvel.models.Item model = mModel;
                // model.urls.get(2).url
                java.lang.String modelUrlsGetInt2Url = null;
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // model != null
                boolean modelJavaLangObjectNull = false;
                // model.urls.get(2) != null
                boolean modelUrlsGetInt2JavaLangObjectNull = false;
                // model.urls
                java.util.ArrayList<com.example.marvel.models.Url> modelUrls = null;
                // activity
                com.example.marvel.view.marvel_details.CharacterDetailsActivity activity = mActivity;
                // model.urls != null
                boolean modelUrlsJavaLangObjectNull = false;
                // model.urls.get(2)
                com.example.marvel.models.Url modelUrlsGetInt2 = null;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {



                    modelJavaLangObjectNull = (model) != (null);
                    if (modelJavaLangObjectNull) {


                        modelUrls = model.getUrls();

                        modelUrlsJavaLangObjectNull = (modelUrls) != (null);
                        if (modelUrlsJavaLangObjectNull) {



                            modelUrlsGetInt2 = modelUrls.get(2);

                            modelUrlsGetInt2JavaLangObjectNull = (modelUrlsGetInt2) != (null);
                            if (modelUrlsGetInt2JavaLangObjectNull) {


                                modelUrlsGetInt2Url = modelUrlsGetInt2.getUrl();

                                activity.goToLink(modelUrlsGetInt2Url);
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // model
                com.example.marvel.models.Item model = mModel;
                // model.urls.get(0) != null
                boolean modelUrlsGetInt0JavaLangObjectNull = false;
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // model != null
                boolean modelJavaLangObjectNull = false;
                // model.urls
                java.util.ArrayList<com.example.marvel.models.Url> modelUrls = null;
                // model.urls.get(0).url
                java.lang.String modelUrlsGetInt0Url = null;
                // activity
                com.example.marvel.view.marvel_details.CharacterDetailsActivity activity = mActivity;
                // model.urls != null
                boolean modelUrlsJavaLangObjectNull = false;
                // model.urls.get(0)
                com.example.marvel.models.Url modelUrlsGetInt0 = null;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {



                    modelJavaLangObjectNull = (model) != (null);
                    if (modelJavaLangObjectNull) {


                        modelUrls = model.getUrls();

                        modelUrlsJavaLangObjectNull = (modelUrls) != (null);
                        if (modelUrlsJavaLangObjectNull) {



                            modelUrlsGetInt0 = modelUrls.get(0);

                            modelUrlsGetInt0JavaLangObjectNull = (modelUrlsGetInt0) != (null);
                            if (modelUrlsGetInt0JavaLangObjectNull) {


                                modelUrlsGetInt0Url = modelUrlsGetInt0.getUrl();

                                activity.goToLink(modelUrlsGetInt0Url);
                            }
                        }
                    }
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // model
                com.example.marvel.models.Item model = mModel;
                // model.urls.get(1)
                com.example.marvel.models.Url modelUrlsGetInt1 = null;
                // activity != null
                boolean activityJavaLangObjectNull = false;
                // model.urls.get(1) != null
                boolean modelUrlsGetInt1JavaLangObjectNull = false;
                // model != null
                boolean modelJavaLangObjectNull = false;
                // model.urls
                java.util.ArrayList<com.example.marvel.models.Url> modelUrls = null;
                // activity
                com.example.marvel.view.marvel_details.CharacterDetailsActivity activity = mActivity;
                // model.urls != null
                boolean modelUrlsJavaLangObjectNull = false;
                // model.urls.get(1).url
                java.lang.String modelUrlsGetInt1Url = null;



                activityJavaLangObjectNull = (activity) != (null);
                if (activityJavaLangObjectNull) {



                    modelJavaLangObjectNull = (model) != (null);
                    if (modelJavaLangObjectNull) {


                        modelUrls = model.getUrls();

                        modelUrlsJavaLangObjectNull = (modelUrls) != (null);
                        if (modelUrlsJavaLangObjectNull) {



                            modelUrlsGetInt1 = modelUrls.get(1);

                            modelUrlsGetInt1JavaLangObjectNull = (modelUrlsGetInt1) != (null);
                            if (modelUrlsGetInt1JavaLangObjectNull) {


                                modelUrlsGetInt1Url = modelUrlsGetInt1.getUrl();

                                activity.goToLink(modelUrlsGetInt1Url);
                            }
                        }
                    }
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): activity
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}