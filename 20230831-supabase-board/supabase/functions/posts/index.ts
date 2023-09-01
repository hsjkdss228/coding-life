import { serve } from 'https://deno.land/std@0.168.0/http/server.ts';

import { supabase } from '../../supabase.ts';
import { corsHeaders } from '../../_shared/cors.ts';

serve(async (request: Request) => {
  const { method } = request;

  if (method === 'OPTIONS') {
    return new Response('OK', { headers: corsHeaders });
  }

  if (method !== 'GET') {
    return new Response(
      'Incorrect HTTP Method',
      {
        headers: {
          ...corsHeaders,
          'Content-Type': 'text/plain',
        },
        status: 400,
      },
    );
  }

  const { data } = await supabase
    .from('posts')
    .select()
    .eq('deleted', false);

  return new Response(
    JSON.stringify(data),
    {
      headers: {
        ...corsHeaders,
        'Content-Type': 'application/json',
      },
      status: 200,
    },
  );
});
