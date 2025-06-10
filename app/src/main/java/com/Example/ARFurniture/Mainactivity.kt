package com.example.arfurniture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Anchor
import com.google.ar.core.HitResult
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class MainActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment
    private var modelRenderable: ModelRenderable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arFragment = supportFragmentManager.findFragmentById(R.id.ux_fragment) as ArFragment

        ModelRenderable.builder()
            .setSource(this, Uri.parse("furniture_model.glb"))
            .setIsFilamentGltf(true)
            .build()
            .thenAccept { modelRenderable = it }

        arFragment.setOnTapArPlaneListener { hitResult: HitResult, _, _ ->
            if (modelRenderable == null) return@setOnTapArPlaneListener

            val anchor: Anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor).apply {
                setParent(arFragment.arSceneView.scene)
            }

            val model = TransformableNode(arFragment.transformationSystem).apply {
                renderable = modelRenderable
                setParent(anchorNode)
                select()
            }
        }
    }
}
