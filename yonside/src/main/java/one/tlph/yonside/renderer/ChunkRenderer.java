package one.tlph.yonside.renderer;

import one.tlph.yonside.Block.Block;
import one.tlph.yonside.Block.BlockPos;
import one.tlph.yonside.Block.Blocks;
import one.tlph.yonside.BlockFacing;
import one.tlph.yonside.World.Chunk;

import java.util.*;

public class ChunkRenderer {

	private final Chunk chunk;
	private ArrayList<Float> vertexData;
	private ArrayList<Integer> indicesData;
	private HashMap<BlockPos, boolean[]> vertexMap;

	public ChunkRenderer(Chunk chunk) {
		this.chunk = chunk;
		this.vertexData = new ArrayList<>();
		this.vertexMap = new HashMap<>();
	}

	public ArrayList<Float> GetChunkMesh() {
		if(vertexData.isEmpty() && vertexMap.isEmpty()) {
			regenerateMesh(true);
			compileGeometryData();
		}
		if(chunk.isDirty()) {
			regenerateMesh(false);
			compileGeometryData();
		}
		return vertexData;
	}

	private void compileGeometryData() {
		for(Map.Entry<BlockPos, boolean[]> entry : vertexMap.entrySet()) {
			for(int i = 0; i < 6; i++) {
				if(entry.getValue()[i]) {
					BlockFacing side = BlockFacing.values()[i];
					int idx = vertexData.size();
					indicesData.add(idx + 0);
					indicesData.add(idx + 1);
					indicesData.add(idx + 2);
					indicesData.add(idx + 2);
					indicesData.add(idx + 3);
					indicesData.add(idx + 0);
					switch(side) {
						case Up:
							for(int x = 0; x < 4; x++) {
								vertexData.add(GLData.Top[x * 3 + 0]);
								vertexData.add(GLData.Top[x * 3 + 1]);
								vertexData.add(GLData.Top[x * 3 + 2]);
								vertexData.add(GLData.TopTex[x * 2 +0]);
								vertexData.add(GLData.TopTex[x * 2 +1]);
							}
							break;
						case Down:
							for(int x = 0; x < 4; x++) {
								vertexData.add(GLData.Bottom[x * 3 + 0]);
								vertexData.add(GLData.Bottom[x * 3 + 1]);
								vertexData.add(GLData.Bottom[x * 3 + 2]);
								vertexData.add(GLData.BottomTex[x * 2 +0]);
								vertexData.add(GLData.BottomTex[x * 2 +1]);
							}
							break;
						case North:
							for(int x = 0; x < 4; x++) {
								vertexData.add(GLData.North[x * 3 + 0]);
								vertexData.add(GLData.North[x * 3 + 1]);
								vertexData.add(GLData.North[x * 3 + 2]);
								vertexData.add(GLData.NorthTex[x * 2 +0]);
								vertexData.add(GLData.NorthTex[x * 2 +1]);
							}
							break;
						case South:
							for(int x = 0; x < 4; x++) {
								vertexData.add(GLData.South[x * 3 + 0]);
								vertexData.add(GLData.South[x * 3 + 1]);
								vertexData.add(GLData.South[x * 3 + 2]);
								vertexData.add(GLData.SouthTex[x * 2 +0]);
								vertexData.add(GLData.SouthTex[x * 2 +1]);
							}
							break;
						case East:
							for(int x = 0; x < 4; x++) {
								vertexData.add(GLData.East[x * 3 + 0]);
								vertexData.add(GLData.East[x * 3 + 1]);
								vertexData.add(GLData.East[x * 3 + 2]);
								vertexData.add(GLData.EastTex[x * 2 +0]);
								vertexData.add(GLData.EastTex[x * 2 +1]);
							}
							break;
						case West:
							for(int x = 0; x < 4; x++) {
								vertexData.add(GLData.West[x * 3 + 0]);
								vertexData.add(GLData.West[x * 3 + 1]);
								vertexData.add(GLData.West[x * 3 + 2]);
								vertexData.add(GLData.WestTex[x * 2 +0]);
								vertexData.add(GLData.WestTex[x * 2 +1]);
							}
							break;
					}
				}
			}
		}
	}

	private void regenerateMesh(boolean forceRegenerate) {
		for(int z = 0; z < Chunk.Depth; z++)
		for(int y = 0; y < Chunk.Height; y++)
		for(int x = 0; x < Chunk.Width; x++) {
			BlockPos pos = new BlockPos(x, y, z);
			Block block = chunk.getBlock(pos);
			//if(block == Blocks.AIR || block == Blocks.EMPTY)
			//	continue;
			//else
				if(block.isDirty() || forceRegenerate) {
				for(BlockFacing facing : BlockFacing.values()) {
					boolean[] sides = vertexMap.getOrDefault(pos, new boolean[6]);
					if(chunk.getBlock(pos.add(facing, 1)).isOpaque()) {
						sides[facing.ordinal()] = false;
					} else {
						sides[facing.ordinal()] = true;
					}
					vertexMap.put(pos, sides);
					block.clearDirty();
				}
			}
		}
		chunk.clearDirty();
	}
}
