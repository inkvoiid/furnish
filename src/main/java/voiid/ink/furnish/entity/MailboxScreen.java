package voiid.ink.furnish.entity;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MailboxScreen extends HandledScreen<MailboxScreenHandler> {
    //Mailbox texture location
    private static final Identifier TEXTURE = new Identifier("furnish", "textures/gui/container/mailboxs.png");

    public MailboxScreen(MailboxScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        //Reduce container height
        this.backgroundHeight = 145;
        //Shift Inventory title down
        this.playerInventoryTitleY = this.backgroundHeight - 86;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        client.getTextureManager().bindTexture(TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}