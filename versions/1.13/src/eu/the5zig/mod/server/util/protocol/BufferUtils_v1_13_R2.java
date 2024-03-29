package eu.the5zig.mod.server.util.protocol;

import io.netty.buffer.Unpooled;

import net.minecraft.server.v1_13_R2.MinecraftKey;
import net.minecraft.server.v1_13_R2.PacketDataSerializer;
import net.minecraft.server.v1_13_R2.PacketPlayOutCustomPayload;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class BufferUtils_v1_13_R2 implements IBufferUtils {

	@Override
	public IPacketBuffer createBuffer() {
		return new PacketBuffer();
	}

	@Override
	public IPacketBuffer createBuffer(Protocol.PayloadType payloadType) {
		return new PacketBuffer(payloadType);
	}

	private class PacketBuffer implements IPacketBuffer {

		private PacketDataSerializer packetDataSerializer;

		public PacketBuffer() {
			this.packetDataSerializer = new PacketDataSerializer(Unpooled.buffer());
		}

		public PacketBuffer(Protocol.PayloadType payloadType) {
			this();
			writeInt(payloadType.ordinal());
		}

		@Override
		public void writeString(String string) {
			packetDataSerializer.a(string);
		}

		@Override
		public void writeInt(int i) {
			packetDataSerializer.writeInt(i);
		}

		@Override
		public void writeLong(long l) {
			packetDataSerializer.writeLong(l);
		}

		@Override
		public void send(Player player, String channel) {
			PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload(MinecraftKey.a(channel), packetDataSerializer);
			((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
		}
	}
}
