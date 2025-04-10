#version 150

uniform sampler2D InSampler;

in vec2 texCoord;
in vec2 sampleStep;

out vec4 fragColor;

void main() {
    vec4 blurred = vec4(0.0);
    float radius = 2;
    for (float a = -radius + 0.05; a <= radius; a += 0.2) {
        blurred += texture(InSampler, texCoord + sampleStep * a);
    }
    blurred += texture(InSampler, texCoord + sampleStep * radius) / 2.0;
    fragColor = vec4(blurred.r ,blurred.g,blurred.b, blurred.a);
}
